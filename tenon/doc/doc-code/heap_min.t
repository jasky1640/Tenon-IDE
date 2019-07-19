module heap_min

  const num heap_max_size = 100;
  ! define the heap size
  var num size = 0;

  var num heap{heap_max_size};
  var num front = 1;
  var num rear = 1;

  function void main()
    ! judge the heap is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      twrite("The heap is empty.");
    else
      twrite("The heap is not empty.");
    end

    insert_num(1, 20);
    insert_num(2, 2);
    insert_num(3, 35);
    insert_num(4, 46);
    insert_num(5, 22);

    for i from 1 to 5 do
      twrite_num(heap{i});
    end
    twrite("-------------");

    delete_num();
    delete_num();

    for i from 1 to 3 do
      twrite_num(heap{i});
    end
    twrite("-------------");

    insert_num(4, 20);
    insert_num(5, 2);
    insert_num(6, 70);
    insert_num(7, 26);
    insert_num(8, 110);
    insert_num(9, 42);
    insert_num(10, 120);

    for i from 1 to 10 do
      twrite_num(heap{i});
    end
    twrite("-------------");


    heap_sort();
    for i from 1 to 10 do
      twrite_num(heap{i});
    end
    twrite("-------------");

    for i from 11 to 100 do
      insert_num(i, i);
    end

    ! judge the stack is full or not
    var bool bFull = isFull();
    if (bFull == true) then
      twrite("The heap is full.");
    else
      twrite("The heap is not full.");
    end

    clear_heap();

    bEmpty = false;
    bEmpty = isEmpty();
    if (bEmpty == true) then
      twrite("The heap is empty.");
    else
      twrite("The heap is not empty.");
    end
  end


  function bool isEmpty()
    if (size == 0) then
      return true;
    else
      return false;
    end
  end

  function bool isFull()
    if (size == 100) then
      return true;
    else
      return false;
    end
  end

  function void insert_num(num index, num value)
    if(index <> size + 1) then
      twrite("The insert position is wrong.");
      return;
    end
    heap{index} = value;
    size++;
    min_heap_fixup(index);
  end

  function void min_heap_fixup(num index)
    var num j = index div 2;
    var num temp = heap{index};
    while ((j >= 1) and (index <> 1)) do
      if (heap{j} < temp) then
        break;
      end
      heap{index} = heap{j};
      index = j;
      j = index div 2;
    heap{index} = temp;
    end
  end

  function void delete_num()
    heap{1} = heap{size};
    size--;
    min_heap_fixdown(1, size);
  end

  function void min_heap_fixdown(num i,num size)
    var num j = 2 * i;
    var num temp = heap{i};
    while (j <= size) do
      if (((j + 1) <= size) and (heap{j + 1} < heap{j})) then
        j++;
      end
      if (heap{j} > temp) then
        break;
      end
      heap{i} = heap{j};
      i = j;
      j = 2 * i;
    end
    heap{i} = temp;
  end

  function void heap_sort()
    for i from size to 2 step -1 do
      var num temp = heap{i};
      heap{i} = heap{1};
      heap{1} = temp;
      min_heap_fixdown(1, i - 1);
    end
  end

  function void clear_heap()
    size = 0;
  end

end
