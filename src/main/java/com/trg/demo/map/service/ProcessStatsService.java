package com.trg.demo.map.service;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trg.demo.map.dao.MapStatsDao;
import com.trg.demo.map.model.MapStatsModel;

@Service
public class ProcessStatsService {

	private final MapStatsDao mapDao;
	
	@Autowired
	public ProcessStatsService(@Qualifier("MemDB") MapStatsDao mapDao) {
		this.mapDao = mapDao;
	}
		
	public TreeMap<String, MapStatsModel>  getStats() {
			return mapDao.getStats();
	}
}
