package com.mashibing.dp.proxy.v11;

/**
 * 实际对象
 */
public class RealSubject implements Subject{
    public void save(){
        System.out.println("insert into ......");
        save2();
    }

    @Override
    public void save2() {
        System.out.println("22222222222222 into ......");
    }

}
