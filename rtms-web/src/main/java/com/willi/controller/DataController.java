package com.willi.controller;

import com.alibaba.fastjson.JSON;
import com.willi.bean.Neigh;
import com.willi.service.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: bigdataplatform
 * @description:前后台通讯调试controller
 * @author: Hoodie_Willi
 * @create: 2020-02-22 17:06
 **/
@Controller
public class DataController {
    @RequestMapping("/sendData")
    public void ReadDataAndSendData(){
        for (int i = 0; i < 20; i++) {
            try {
                Neigh neigh1 = new Neigh(117, "东城区");
                Neigh neigh2 = new Neigh(22, "西城区");
                String s = JSON.toJSONString(neigh1);
                String s2 = JSON.toJSONString(neigh2);
                System.out.println();
                WebSocketServer.sendInfo(s);
                WebSocketServer.sendInfo(s2);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        return "index";
    }

}
