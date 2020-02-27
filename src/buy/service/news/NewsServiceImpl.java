package buy.service.news;

import buy.dao.news.INewDao;
import buy.dao.news.NewsDaoImpl;
import buy.entity.EasybuyNews;

import java.util.List;

public class NewsServiceImpl implements INewsService {
    INewDao newDao=new NewsDaoImpl();
    @Override
    public List<EasybuyNews> getAllNewsList() {

        return newDao.getAllNewsList();
    }
}
