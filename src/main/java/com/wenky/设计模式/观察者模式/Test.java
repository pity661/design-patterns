package com.wenky.设计模式.观察者模式;

import com.wenky.设计模式.观察者模式.watched.Transporter;
import com.wenky.设计模式.观察者模式.watched.Watched;
import com.wenky.设计模式.观察者模式.watcher.Police;
import com.wenky.设计模式.观察者模式.watcher.Security;
import com.wenky.设计模式.观察者模式.watcher.Thief;
import com.wenky.设计模式.观察者模式.watcher.Watcher;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 16:32
 */
public class Test {
    public static void main(String[] args) {
        //
        Watched watched = new Transporter();
        Watcher watcher1 = new Police();
        Watcher watcher2 = new Security();
        Watcher watcher3 = new Thief();
        watched.addWatcher(watcher1);
        watched.addWatcher(watcher2);
        watched.addWatcher(watcher3);
        watched.notifyWatchers();
    }
}
