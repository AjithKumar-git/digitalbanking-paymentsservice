package com.capg.paymentservice.service.impl;

import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.paymentservice.dao.PayeeDao;
import com.capg.paymentservice.dao.RegisteredBillersDao;
import com.capg.paymentservice.dao.UserBillerDao;
import com.capg.paymentservice.model.PayeeDetails;
import com.capg.paymentservice.model.RegisteredBillers;
import com.capg.paymentservice.model.UserBillers;
import com.capg.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	
	static Logger logger = Logger.getLogger(PaymentServiceImpl.class);
	
	@Autowired
    private RegisteredBillersDao regBillersDao;

	@Autowired
    private PayeeDao payeeDao;
	
	@Autowired
    private UserBillerDao billersDao;



	@Override
	public Boolean addPayee(PayeeDetails payeeDetails) {
		logger.info("In Service : Adding Payee");
		payeeDao.save(payeeDetails);
		return Boolean.TRUE;
	}

	@Override
	public Boolean removePayee(PayeeDetails payeeDetails) {
		logger.info("In Service : Removing Payee");
		payeeDao.delete(payeeDetails);
		return Boolean.FALSE;
	}

	@Override
	public List<PayeeDetails> findPayeesByUserId(String userId) {
		logger.info("In Service : Finding Payee by UserId");
		return payeeDao.findPayeesByUserId(userId);
	}

	@Override
	public List<UserBillers> getBillersByUserId(String userId) {
		if(userId== null){
			logger.warn("Invalid userId no for fetching billers");
			return null;
		}
		logger.info("In Service : Finding Billers by userId");
		return billersDao.findUserBillersByUserId(userId);
	}

	@Override
	public Boolean removeBiller(UserBillers userBiller) {
		logger.info("In Service : Removing Biller");
		billersDao.delete(userBiller);
		return Boolean.TRUE;
	}

	@Override
	public Boolean addBiller(UserBillers userBiller) {
		logger.info("In Service : Adding Biller");
		billersDao.save(userBiller);
		return Boolean.TRUE;
	}


	@Override
	public List<RegisteredBillers> getAllBillers() {
		logger.info("In Service : Getting All Billers");
		return regBillersDao.findAll();
	}
}
