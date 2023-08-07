package com.example.simple_crud.config;

import com.example.simple_crud.model.User;
import com.example.simple_crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
 public class UserConfigurationSchedule {
  private final UserRepository userRepository;
  
 
//@Scheduled(fixedDelay = 2,initialDelay = 4,timeUnit = TimeUnit.SECONDS)
public void print() throws InterruptedException {
 
 Thread.sleep(3000);
 System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));

}
@Scheduled(cron = "0 00 00 1 * *")
private void saveUserFirstname(){

    this.userRepository.findAll().stream().collect(Collectors.groupingBy(User::getFirstname));

// List<User> users=this.userRepository.findAll()
//         .stream().filter(user -> {
//          if (user.getFirstname().length()>=7) {
//           user.setFirstname("HASANBOY");
//           return true;
//          }
//          else return false;
//         }).toList();
    
    
 this.userRepository.saveAll(this.userRepository.findAll()
         .stream().filter(user -> {
             if (user.getFirstname().length()>=7) {
                 user.setFirstname("HASANBOY");
                 return true;
             }
             else return false;
         }).toList());
 
 
// DoubleStream doubleStream= users.stream().mapToInt(User::getId).asDoubleStream();
//List<User> users1=new ArrayList<>();
// for (User user : users1) {
//  if (user.getFirstname().length()>=7){
//   user.setFirstname("HASANBOY");
//  }
//  
// }
}
   

}
