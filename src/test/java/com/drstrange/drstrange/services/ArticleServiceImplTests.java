package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.ArticleRepository;
import com.drstrange.drstrange.models.Article;
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
public class ArticleServiceImplTests {
  @Mock
  ArticleRepository mockRepository;
  
  @InjectMocks
  ArticleServiceImpl service;
  
  @Test
  public void FindByName_Returns_Entity_When_NamesAreEquals() {
    String title = "Cats";
    Mockito.when(mockRepository.findByName(title)).thenReturn(
		  Arrays.asList(
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null)
		  ));
    List<Article> result = service.findByName("Cats");
    Assert.assertEquals(4,result.size());
    Assert.assertEquals("Cats",result.get(0).getTitle());
    Assert.assertEquals("Cats",result.get(1).getTitle());
    Assert.assertEquals("Cats",result.get(2).getTitle());
    Assert.assertEquals("Cats",result.get(3).getTitle());
  }
  
  @Test
  public void FindBySequence_Returns_Entity_When_TopicAreEquals() {
    String topic = "cat";
    Mockito.when(mockRepository.filterBySequence(topic)).thenReturn(
		  Arrays.asList(
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats", "cat", 1, "Cats love to sleep", null)
		  ));
    List<Article> result = service.filterBySequence("cat");
    Assert.assertEquals(4,result.size());
    Assert.assertEquals("cat",result.get(0).getTopic());
    Assert.assertEquals("cat",result.get(1).getTopic());
    Assert.assertEquals("cat",result.get(2).getTopic());
    Assert.assertEquals("cat",result.get(3).getTopic());
  }
  @Test
  public void GetAll_Returns_AllEntities() {
    Mockito.when(mockRepository.listAllArticle())
		  .thenReturn(Arrays.asList(
				new Article("Cats", "cat", 1, "Cats love to sleep", null),
				new Article("Cats2", "cat", 1, "Cats love to sleep", null),
				new Article("Cats3", "cat", 1, "Cats love to sleep", null),
				new Article("Cats4", "cat", 1, "Cats love to sleep", null)
		  ));
    
    List<Article> result = service.listAllArticle();
    
    Assert.assertEquals(4, result.size());
  }
  
//  @Test
//  public void FindByAuthor_Returns_Entity_When_IdIsEqual() {
//    Mockito.when(mockRepository.findByAuthor(1))
//		  .thenReturn(Arrays.asList(
//				new Article("Cats", "cat", 1, "Cats love to sleep", null),
//				new Article("Cats2", "cat", 1, "Cats love to sleep", null),
//				new Article("Cats3", "cat", 1, "Cats love to sleep", null),
//				new Article("Cats4", "cat", 1, "Cats love to sleep", null)
//		  ));
//
//    List<Article> result = service.findByAuthor(1);
//    Assert.assertEquals(1, result.size());
//  }
}

