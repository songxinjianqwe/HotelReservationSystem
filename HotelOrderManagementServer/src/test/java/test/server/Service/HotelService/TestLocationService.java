package test.server.Service.HotelService;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.VO.LocationVO;
import hrs.server.Service.Interface.HotelService.LocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestLocationService {
	@Autowired
	private LocationService service;
	
	@Test
	public void testFindAll(){
		List<LocationVO> list = service.findAll();
		for(LocationVO vo:list){
			System.out.println(vo);
		}
		assertNotNull(list);
	}
	
}	
