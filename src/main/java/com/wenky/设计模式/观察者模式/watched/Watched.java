package com.wenky.设计模式.观察者模式.watched;

import com.wenky.设计模式.观察者模式.watcher.Watcher;

public interface Watched {
  public void addWatcher(Watcher watcher);

  public void removeWatcher(Watcher watcher);

  public void notifyWatchers();
}
