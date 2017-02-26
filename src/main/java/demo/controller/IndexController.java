package demo.controller;

import demo.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.composed.web.rest.GetResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	private final CustomService customService;

	@Autowired
	public IndexController(CustomService customService) {
		this.customService = customService;
	}

	@GetResource
	public ResponseEntity<String> method(@RequestBody String value) {
		return ResponseEntity.ok(customService.get(value));
	}
}
