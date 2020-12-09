package soft.bean;
public class PagePOJO {

    private int totalNumber;//当前表中总条目数量

    private int currentPage;//当前页的位置

    private int totalPage;//总页数

    private int pageSize;//页面大小

    private int startIndex;//检索的起始位置

    private int totalSelect;//检索的总数目

//...省略其他set，get方法

    public void setTotalNumber(int totalNumber) {

        this.totalNumber = totalNumber;

        this.count();

    }

//...省略其他set，get方法


    public PagePOJO(int totalNumber, int currentPage, int totalPage, int pageSize, int startIndex, int totalSelect) {

        super();

        this.totalNumber = totalNumber;

        this.currentPage = currentPage;

        this.totalPage = totalPage;

        this.pageSize = pageSize;

        this.startIndex = startIndex;

        this.totalSelect = totalSelect;

    }

    public void count(){

        int totalPageTemp = this.totalNumber/this.pageSize;

        int plus = (this.totalNumber%this.pageSize)==0?0:1;

        totalPageTemp = totalPageTemp+plus;

        if(totalPageTemp<=0){

            totalPageTemp=1;

        }

        this.totalPage = totalPageTemp;//总页数


        if(this.totalPage<this.currentPage){

            this.currentPage = this.totalPage;

        }

        if(this.currentPage<1){

            this.currentPage=1;

        }

        this.startIndex = (this.currentPage-1)*this.pageSize;//起始位置等于之前所有页面输乘以页面大小

        this.totalSelect = this.pageSize;//检索数量等于页面大小

    }

}