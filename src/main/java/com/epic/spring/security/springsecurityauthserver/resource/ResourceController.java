/**
 * 
 */
package com.epic.spring.security.springsecurityauthserver.resource;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duleepa_w
 *
 */

@RestController
@RequestMapping("/rest/hello")
public class ResourceController {

	@GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }
	
	@GetMapping
	public String hello() {		
		return "Hello world";
	}
}
