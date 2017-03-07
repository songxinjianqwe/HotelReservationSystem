package test.server.Service.PromotionService;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hrs.common.Exception.PromotionService.EnterpriseNotFoundException;
import hrs.common.VO.EnterpriseVO;
import hrs.server.Service.Interface.PromotionService.EnterpriseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestEnterpriseService {
	@Autowired
	private EnterpriseService service;
	
	@Test
	public void testFindNotAddedEnterpriseByHotelID() throws EnterpriseNotFoundException{
		List<EnterpriseVO> vos = service.findNotAddedEnterpriseByHotelID(1);
		for(EnterpriseVO vo:vos){
			System.out.println(vo);
		}
	}
}
