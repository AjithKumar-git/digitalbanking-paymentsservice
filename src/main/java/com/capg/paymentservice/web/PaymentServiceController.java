package com.capg.paymentservice.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.paymentservice.model.PayeeDetails;
import com.capg.paymentservice.model.RegisteredBillers;
import com.capg.paymentservice.model.UserBillers;
import com.capg.paymentservice.service.PaymentService;

@RestController
@ComponentScan("com.capg.paymentservices")
@CrossOrigin
@EnableAutoConfiguration
public class PaymentServiceController {
	
	static Logger logger = Logger.getLogger(PaymentServiceController.class);
	
	@Autowired
	PaymentService paymentService;
	
	
	
	@RequestMapping(value="/paymentservices/addBiller"
			,method = RequestMethod.POST)
	public Boolean addBiller(@RequestBody UserBillers userBiller) {
		if(userBiller == null){
			logger.warn("userBiller is invalid");
			return null;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.addBiller(userBiller);
	}

	
	
	@RequestMapping(value="/paymentservices/removeBiller"
			,method = RequestMethod.POST)
	public Boolean removeBiller(@RequestBody UserBillers userBiller) {
		if(userBiller == null){
			logger.warn("UserBiller object is invalid");
			return null;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.removeBiller(userBiller);
	}

	
	
	@RequestMapping(value="/paymentservices/getBillersByUserId/{userId}"
			,method = RequestMethod.GET)
	public List<UserBillers> getBillersByUserId(@PathVariable String userId) {
		if(userId == null){
			logger.warn("userId is invalid");
			return null;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.getBillersByUserId(userId);
	}
	
	
	
	@RequestMapping(value="/paymentservices/addPayee"
			,method = RequestMethod.POST)
	public Boolean addPayee(@RequestBody PayeeDetails payeeDetails) {
		if(payeeDetails == null){
			logger.warn("Payee details are invalid");
			return Boolean.FALSE;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.addPayee(payeeDetails);
	}

	
	
	@RequestMapping(value="/paymentservices/removePayee"
			,method = RequestMethod.POST)
	public Boolean removePayee(@RequestBody PayeeDetails payeeDetails) {
		if(payeeDetails == null){
			logger.warn("Payee details are invalid");
			return Boolean.FALSE;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.removePayee(payeeDetails);
	}

	
	
	@RequestMapping(value="/paymentservices/getPayeeList/{userId}"
			,method = RequestMethod.GET)
	public List<PayeeDetails> findPayeeByUserId(@PathVariable String userId) {
		if(userId == null){
			logger.warn("userId is invalid");
			return null;
		}
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.findPayeesByUserId(userId);
	}

	
	
	@RequestMapping(value="/paymentservices/getAllBillers"
			,method = RequestMethod.GET)
	public List<RegisteredBillers> getAllBillers() {
		logger.info("Request Mapping Successfull \n \n");
		return paymentService.getAllBillers();
	}


}
