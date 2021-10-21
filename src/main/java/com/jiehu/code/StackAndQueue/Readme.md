# 堆栈与队列

## 1.堆栈

### 1.1 方法
增加：
add(E e)：在链表后添加一个元素；   通用方法
addFirst(E e)：在链表头部插入一个元素；  特有方法
addLast(E e)：在链表尾部添加一个元素；  特有方法
push(E e)：与addFirst方法一致  
offer(E e)：在链表尾部插入一个元素                                                                                                                                                  
add(int index, E element)：在指定位置插入一个元素。      
offerFirst(E e)：JDK1.6版本之后，在头部添加； 特有方法                                                                                                         
offerLast(E e)：JDK1.6版本之后，在尾部添加； 特有方法

删除：
remove() ：移除链表中第一个元素;    通用方法  
remove(E e)：移除指定元素；   通用方法
removeFirst(E e)：删除头，获取元素并删除；  特有方法
removeLast(E e)：删除尾；  特有方法
pollFirst()：删除头；  特有方法
pollLast()：删除尾；  特有方法
pop()：和removeFirst方法一致，删除头。 
poll()：查询并移除第一个元素     特有方法    

查：
get(int index)：按照下标获取元素；  通用方法
getFirst()：获取第一个元素；  特有方法
getLast()：获取最后一个元素； 特有方法
peek()：获取第一个元素，但是不移除；  特有方法
peekFirst()：获取第一个元素，但是不移除； 
peekLast()：获取最后一个元素，但是不移除；
pollFirst()：查询并删除头；  特有方法
pollLast()：删除尾；  特有方法
poll()：查询并移除第一个元素     特有方法

改
public E set(int index, E element)，设置指定位置的元素；

其他
public Object clone()，克隆该列表；
public Iterator<E> descendingIterator()，返回倒序迭代器；
public int size()，返回链表元素个数；
public ListIterator<E> listIterator(int index)，返回从指定位置开始到末尾的迭代器；
public Object[] toArray()，返回一个由链表元素组成的数组；
public <T> T[] toArray(T[] a)，返回一个由链表元素转换类型而成的数组；

## 2.单调栈

单调栈就是栈里面存放的数据都是有序的，所以可以分为单调递增栈和单调递减栈两种。
````
单调递增栈就是从栈底到栈顶是从大到小
单调递减栈就是从栈底到栈顶是从小到大
````