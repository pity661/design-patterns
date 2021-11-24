package com.wenky.设计模式.观察者模式.watched;

import com.wenky.设计模式.观察者模式.watcher.Watcher;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-09 16:30
 */
public class Transporter implements Watched {
  private List<Watcher> list = new ArrayList<>();

  @Override
  public void addWatcher(Watcher watcher) {
    list.add(watcher);
  }

  @Override
  public void removeWatcher(Watcher watcher) {
    list.remove(watcher);
  }

  @Override
  public void notifyWatchers() {
    list.stream().forEach(watcher -> watcher.update());
  }
}
