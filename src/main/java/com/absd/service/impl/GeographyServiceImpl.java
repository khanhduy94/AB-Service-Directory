package com.absd.service.impl;

import com.absd.dao.GeographyDAO;
import com.absd.entity.Geography;
import com.absd.service.GeographyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
// This class implement interface which declare in GeographyServiceImpl
// interface
public class GeographyServiceImpl implements GeographyService {

	public GeographyServiceImpl() {
		System.out.println("GeographyServiceImpl()");
	}

	@Autowired
	private GeographyDAO geographyDAO;

	@Override
	public long createGeography(Geography geography) {
		return geographyDAO.createGeography(geography);
	}

	@Override
	public Geography updateGeography(Geography geography) {
		return geographyDAO.updateGeography(geography);
	}

	@Override
	public void deleteGeography(long id) {
		geographyDAO.deleteGeography(id);
	}

	@Override
	public List<Geography> getAllGeographys() {
		return geographyDAO.getAllGeographys();
	}

	@Override
	public Geography getGeography(long id) {
		return geographyDAO.getGeography(id);
	}

	@Override
	public List<Geography> getAllGeographys(String geographyName) {
		return geographyDAO.getAllGeographys(geographyName);
	}
}
