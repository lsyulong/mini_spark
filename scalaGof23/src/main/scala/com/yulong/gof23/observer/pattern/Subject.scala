package com.yulong.gof23.observer.pattern

trait Subject {
  def registerObserver(o: Observer)

  def removeObserver(o: Observer)

  def notifyObserver()
}
