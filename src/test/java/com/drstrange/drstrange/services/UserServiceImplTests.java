package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith (MockitoJUnitRunner.class)

public class UserServiceImplTests {
  @Mock
  UserRepository mockRepository;
  
  @InjectMocks
  UserServiceImpl service;
  
  @Test
  public void LoginValidation_Returns_Entity_When_EmailAndPasswordAreEquals() {
    String email = "gosho@gmail.com";
    String password = "gosho123";
    Mockito.when(mockRepository.loginValidation(email, password)).thenReturn(
            Arrays.asList(
                    new User("Gosho", "Markov", "gosho@gmail.com", "gosho123", "Goshana")
            ));
    List<User> result = service.loginValidation("gosho@gmail.com","gosho123");
    Assert.assertEquals(1,result.size());
    Assert.assertEquals("gosho@gmail.com",result.get(0).getEmail());
    Assert.assertEquals("gosho123",result.get(0).getPassword());
  }
  
  @Test
  public void FindByName_Returns_Entity_When_NamesAreEquals() {
    String firstname = "Ganka";
    Mockito.when(mockRepository.findByName(firstname)).thenReturn(
            Arrays.asList(
                    new User("Ganka", "Markova", "ganka@gmail.com", "gankaesuper", "Gancheto"),
                    new User("Ganka", "Marinova", "ganka12@gmail.com", "gankaesuper123", "Gancheto12"),
                    new User("Ganka", "Marinelova", "ganka34@gmail.com", "gankaesuper321", "Gancheto03"),
                    new User("Ganka", "Martinova", "ganka66@gmail.com", "gankaesuper213", "Gancheto07")
            ));
    List<User> result = service.findByName("Ganka");
    Assert.assertEquals(4,result.size());
    Assert.assertEquals("Ganka",result.get(0).getFirstname());
    Assert.assertEquals("Ganka",result.get(1).getFirstname());
    Assert.assertEquals("Ganka",result.get(2).getFirstname());
    Assert.assertEquals("Ganka",result.get(3).getFirstname());
  }
  
  @Test
  public void FindById_Returns_Entity_When_NamesAreEquals() {
    int userID = 16;
    User user = new User("Ganka", "Markova", "ganka@gmail.com", "gankaesuper", "Gancheto");
    user.setId(16);
    Mockito.when(mockRepository.findById(userID)).thenReturn(user);
    User result = service.findById(userID);
    Assert.assertEquals(userID,result.getId());
  }
}
