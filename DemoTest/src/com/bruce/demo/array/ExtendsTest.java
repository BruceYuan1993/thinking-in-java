package com.bruce.demo.array;



interface IA {}
class B {}
class C extends B implements IA
{
}
public class ExtendsTest {
 C[] arr = new C[9];
 B[] barr = arr;
 IA[] iarr = arr;
}
