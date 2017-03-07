package test.server.Service.HotelService;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.VO.CommercialCircleVO;
import hrs.server.Service.Interface.HotelService.CommCircleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCommCircleService {
	@Autowired
	private CommCircleService service;

	@Test
	public void testFindByLoc() {
		List<CommercialCircleVO> list = service.findByLoc(1);
		for (CommercialCircleVO vo : list) {
			System.out.println(vo);
			assertEquals(vo.location.id, 1);
		}
	}

}
