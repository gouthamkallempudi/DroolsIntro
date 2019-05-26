package com.taxdrools.taxdrools.Service;

import com.taxdrools.taxdrools.Config.DrollsBeanFactory;
import com.taxdrools.taxdrools.Model.Employee;
import com.taxdrools.taxdrools.Model.Hike;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class HikeService {



     public Hike getHike(Employee employee , Hike hike){
         KieSession kieSession=new DrollsBeanFactory().getKieSession();
         kieSession.insert(employee);
         kieSession.setGlobal("hike" , hike);
         kieSession.fireAllRules();
         System.out.println(hike.getHike());
         return hike;
     }
}
