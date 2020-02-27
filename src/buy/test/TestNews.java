package buy.test;

import buy.dao.news.NewsDaoImpl;
import org.junit.Test;

public class TestNews {
    @Test
    public void testNews(){
        NewsDaoImpl newsDao=new NewsDaoImpl();
        System.out.println(newsDao.getAllNewsList().size());
    }
}
