package com.ufo.learnfrance.utils;

public class Native
{
  static
  {
    System.loadLibrary("test");
  }
  
  public native String getName();
}
