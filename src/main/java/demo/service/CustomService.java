package demo.service;

import org.springframework.stereotype.Service;

@Service
public class CustomService {
	public String get(String value) {
		return "custom value: " + value;
	}
}
