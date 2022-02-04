package com.tsystem.mgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystem.mgmt.model.Address;
import com.tsystem.mgmt.repository.PersonAddressRepository;

@RestController
@RequestMapping("/mgmt")
public class PersonAddressController {

	@Autowired
	private PersonAddressRepository personAddressRepository;

	@GetMapping("/get-all-address")
	List<Address> getAllAddress() {
		return personAddressRepository.findAll();
	}

	@PostMapping("/save-address")
	ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		return new ResponseEntity<>(personAddressRepository.save(address), HttpStatus.CREATED);
	}

	@PostMapping("/update-address")
	ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
		Optional<Address> addressData = personAddressRepository.findById(id);
		if (addressData.isPresent()) {
			Address updateAddress = addressData.get();
			updateAddress.setName(address.getName());
			updateAddress.setCity(address.getCity());
			updateAddress.setState(address.getState());
			updateAddress.setStreetAddress(address.getStreetAddress());
			updateAddress.setZipCode(address.getZipCode());
			return new ResponseEntity<>(personAddressRepository.save(address), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get-address-by-name/{name}")
	ResponseEntity<List<Address>> getAddressByName(@PathVariable String name) {
		return new ResponseEntity<>(personAddressRepository.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/get-address-by-id/{Id}")
	ResponseEntity<Address> getAddressById(@PathVariable Long id) {
		return new ResponseEntity<>(personAddressRepository.findById(id).get(), HttpStatus.OK);
	}

	@DeleteMapping("/delete-address/{id}")
	ResponseEntity<HttpStatus> deleteAddress(@PathVariable Long id) {
		personAddressRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
