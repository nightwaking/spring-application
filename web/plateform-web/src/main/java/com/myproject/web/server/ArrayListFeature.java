package com.myproject.web.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListFeature {
    public static void main(String[] args) {
        // ArrayList定义过程
        List<Person> personList1 = new ArrayList<>();
        List<Person> personList2 = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        integerList.stream().filter(l -> l > 3).forEach(System.out::println);

        Person person1 = new Person("name");

        personList1.add(person1);
        personList1.remove(0);
        personList1.get(1);

        System.out.println("personList1.size() = " + personList1.size());
        System.out.println("personList2.size() = " + personList2.size());

        System.out.println();
//         执行流程，new关键字，在栈空间中保存ArrayList的引用（personList1）,在堆内存中开辟了一块空间
//         构造方法做的事情
//         static 修饰的变量，常驻于方法区,不需要new，JVM会提前初始化好，这个特性在实际开发中常作为缓存。
//         private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = []
//         public ArrayList() {
//              this.elementDate = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//         }
//        执行Person person1 = new Person("name");
//        执行personList1.add(person1);
//        public boolean add (E e){
//            ensureCapacityInternal(size + 1);
//            elementData[size ++] = e;
//            return true;
//        }
//        private static final int DEFAULT_CAPACITY = 10;
//
//        ensureCapacityInternall(int minCapacity) {
//            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
//            }
//            ensureExplicitCapacity(minCapacity);
//        }
//        private void ensureExplicitCapacity(int minCapacity) {
//            modCount ++; // 记录修改次数
//
//            if (minCapacity - elementData.length > 0) {
//                grow(minCapacity); // 如果传入的值大于底层数组的长度,继续grow方法
//            }
//        }
//        public void grow(int minCapacity) {
//            int oldCapacity = elementData.length;
//            int newCapacity = oldCapacity + (oldCapacity >> 2);
//            if (newCapacity - minCapacity < 0)
//                newCapacity = minCapacity;
//            // 大于最大数据长度，直接赋值为最大 int 长度
//            if (newCapacity - MAX_ARRAY_SIZE > 0)
//                newCapacity = hugeCapacity(minCapacity);
//            elementData = Arrays.copyOf(elementData, newCapacity);
//      }
//      数组一旦在堆内存中创建，数组的长度就是不变的如果想要删除数组中的元素，
//      只能把想要删除的相应位置的值置换为null,(数组空洞)，容易造成空指针异常。把null后面值复制一份，
//      向前拷贝，但最后的一位的引用的指向是不变的，与倒数第二位指向同一对象。再次处理，将最后一位重
//      置为null,但数组的长度还是10需要自定义一个size来记录数组长度。
//      ArrayList的元素删除方式
//      按照下标删除
//        List<Person> perList = new ArrayList<>();
//        perList.add(new Person("name0"));
//        perList.add(new Person("name1"));
//        perList.add(new Person("name3"));
//        perList.add(new Person("name4"));
//
//        perList.add(1, new Person("name5"));
//        perList.remove(1);
//        perList.remove(new Person("name4"));
//        System.out.println(perList.size());
//      remove方法的源码
//        public E remove(int index) {
//            rangeCheck(index); // 检查数组是否越界
//            modCount++; // 记录修改次数
//            E oldValue = elementData(index);
//            int numMoved = size - index - 1; // 计算需要拷贝的元素个数
//            if (numMoved > 0 //将index + 1 之后的元素向前拷贝
//                System.arraycopy(elementData, index + 1, elementData, index, numMoved);
//            elementData[--size] = null;  size = size - 1， elementData[size] = null; size减少1，数组最后一位赋值为null
//        }
//      直接删除元素
//        public boolean remove(Object o) {
//            if (o == null) {  // 循环寻找null值
//                for (int index = 0; index < size; index++){
//                    if (elementData[index] == null){
//                      fastRemove(index); // 找到null值执行fastRemove
//                      return true;
//                    }
//                }
//            } else {
//                 for (int index = 0; index < size; index ++){
//                     if (o.equals(elementData[index]) {
//                          fastRemove(index);
//                          return true;
//                     }
//                 }
//            }
//            return false;
//        }
    }
    }
