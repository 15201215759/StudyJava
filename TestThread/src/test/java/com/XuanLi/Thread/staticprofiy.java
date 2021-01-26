package com.XuanLi.Thread;

/**
 * 静态代理设计模式
 * staticproxy
 * 1.真实角色
 * 2.代理角色   持有真是角色的引用
 * 3.二者实现相同的接口
 */
public class staticprofiy {
/**
 *
 */
public static void main(String[] args) {
    //1. 创建真是角色
    You you = new You();
    //2. 创建代理角色
    weddingCompany weddingCompany = new weddingCompany(you);
    //3. 执行你的任务
    weddingCompany.before();
    weddingCompany.marry();
    weddingCompany.after();

}

}

//共同实现的接口
interface Marry{
    public abstract void marry();
}

//真是角色
class You implements Marry {

    public void marry() {
        System.out.println("工作进行中====");
    }
}

//代理角色
class weddingCompany implements Marry {
    //持有真是角色的引用
    private Marry you;

    public weddingCompany(Marry you) {
        this.you = you;
    }

    public weddingCompany() {
    }

    public void before(){
        System.out.println("准备工作======");
    }
    public void marry() {
        you.marry();
    }
    public void after(){
        System.out.println("后续工作======");
    }
}
