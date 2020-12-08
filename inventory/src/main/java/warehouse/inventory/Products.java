package warehouse.inventory;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products
{
    private ArrayList<Contain_articles> contain_articles;

    private String name;

    public ArrayList<Contain_articles> getContain_articles ()
    {
        return contain_articles;
    }

    public void setContain_articles (ArrayList<Contain_articles> contain_articles)
    {
        this.contain_articles = contain_articles;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contain_articles = "+contain_articles+", name = "+name+"]";
    }
}
			
			
