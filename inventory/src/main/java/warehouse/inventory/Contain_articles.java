package warehouse.inventory;


public class Contain_articles
{
    private String amount_of;

    private String art_id;

    public String getAmount_of ()
    {
        return amount_of;
    }

    public void setAmount_of (String amount_of)
    {
        this.amount_of = amount_of;
    }

    public String getArt_id ()
    {
        return art_id;
    }

    public void setArt_id (String art_id)
    {
        this.art_id = art_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount_of = "+amount_of+", art_id = "+art_id+"]";
    }
}
			
			
