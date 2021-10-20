# 堆栈与队列

## 1.堆栈

### 1.1 方法
增
public boolean add(E e)，链表末尾添加元素，返回是否成功；
public void add(int index, E element)，向指定位置插入元素；
public boolean addAll(Collection<? extends E> c)，将一个集合的所有元素添加到链表后面，返回是否成功；
public boolean addAll(int index, Collection<? extends E> c)，将一个集合的所有元素添加到链表的指定位置后面，返回是否成功；
public void addFirst(E e)，添加到第一个元素；
public void addLast(E e)，添加到最后一个元素；
public boolean offer(E e)，向链表末尾添加元素，返回是否成功；
public boolean offerFirst(E e)，头部插入元素，返回是否成功；
public boolean offerLast(E e)，尾部插入元素，返回是否成功；

删
public void clear()，清空链表；
public E removeFirst()，删除并返回第一个元素；
public E removeLast()，删除并返回最后一个元素；
public boolean remove(Object o)，删除某一元素，返回是否成功；
public E remove(int index)，删除指定位置的元素；
public E poll()，删除并返回第一个元素；
public E remove()，删除并返回第一个元素；

查
public boolean contains(Object o)，判断是否含有某一元素；
public E get(int index)，返回指定位置的元素；
public E getFirst(), 返回第一个元素；
public E getLast()，返回最后一个元素；
public int indexOf(Object o)，查找指定元素从前往后第一次出现的索引；
public int lastIndexOf(Object o)，查找指定元素最后一次出现的索引；
public E peek()，返回第一个元素；
public E element()，返回第一个元素；
public E peekFirst()，返回头部元素；
public E peekLast()，返回尾部元素；

改
public E set(int index, E element)，设置指定位置的元素；

其他
public Object clone()，克隆该列表；
public Iterator<E> descendingIterator()，返回倒序迭代器；
public int size()，返回链表元素个数；
public ListIterator<E> listIterator(int index)，返回从指定位置开始到末尾的迭代器；
public Object[] toArray()，返回一个由链表元素组成的数组；
public <T> T[] toArray(T[] a)，返回一个由链表元素转换类型而成的数组；
