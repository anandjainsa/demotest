package org.kp.tpmg.ttg.clinicianconnect.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kp.tpmg.ttg.clinicianconnect.web.dao.impl.TestDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Autowired
	public TestDAO dao;
	
	private static Logger LOG = LogManager.getLogger(TestController.class); 

	@RequestMapping("/test")
	public List<String> customerInformation() throws SQLException {
		LOG.debug("-----test-------------");
		return dao.isData();
		
	}
}