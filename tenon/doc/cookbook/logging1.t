! RUN: tenon -m base %s | FileCheck %s

module logging

  const num heap_max_size = 100;
  ! define the heap size
  var num size = 0;

  var num heap{heap_max_size};
  var num front = 1;
  var num rear = 1;

  function void main()
    var string str = getLogDefaultHandler();
    tpwrite_string(str);
    str = getLogDefaultMarker();
    tpwrite_string(str);
    str = getLogDefaultLevel();
    tpwrite_string(str);

    ! judge the heap is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      tpwrite("The heap is empty.");
    else
      tpwrite("The heap is not empty.");
    end

    insert_num(1, 20);
    insert_num(2, 2);
    insert_num(3, 35);
    insert_num(4, 46);
    insert_num(5, 22);

    for i from 1 to 5 do
      tpwrite_num(heap{i});
    end
    log_info("-------------");

    delete_num();
    delete_num();

    for i from 1 to 3 do
      tpwrite_num(heap{i});
    end
    log_info("-------------");

    insert_num(4, 80);
    insert_num(5, 62);
    insert_num(6, 70);
    insert_num(7, 26);
    insert_num(8, 110);
    insert_num(9, 42);
    insert_num(10, 120);

    for i from 1 to 10 do
      tpwrite_num(heap{i});
    end
    tpwrite("-------------");


    heap_sort();
    for i from 1 to 10 do
      tpwrite_num(heap{i});
    end
    tpwrite("-------------");

    for i from 11 to 100 do
      insert_num(i, i);
    end

    ! judge the stack is full or not
    log("INFO", "Before the ifFull() function.");
    var bool bFull = isFull();
    if (bFull == true) then
      tpwrite("The heap is full.");
    else
      tpwrite("The heap is not full.");
    end

    clear_heap();

    bEmpty = false;
    bEmpty = isEmpty();
    if (bEmpty == true) then
      tpwrite("The heap is empty.");
    else
      tpwrite("The heap is not empty.");
    end
  end


  function bool isEmpty()
    log_info("In the isEmpty() function.");
    if (size == 0) then
      return true;
    else
      return false;
    end
  end

  function bool isFull()
    log("INFO","In the isFull() function.");
    if (size == 100) then
      return true;
    else
      return false;
    end
  end

  function void insert_num(num index, num value)
    if(index <> size + 1) then
      tpwrite("The insert position is wrong.");
      return;
    end
    heap{index} = value;
    size++;
    max_heap_fixup(index);
  end

  function void max_heap_fixup(num index)
    log_marker("FIXUP", "INFO", "In the beggining of the max_heap_fixup().");
    var num j = index div 2;
    var num temp = heap{index};
    while ((j >= 1) and (index <> 1)) do
      if (heap{j} > temp) then
        break;
      end
      heap{index} = heap{j};
      index = j;
      j = index div 2;
    heap{index} = temp;
    end
    log_marker("SYSTEM", "INFO", "In the end of the max_heap_fixup().");
  end

  function void delete_num()
    heap{1} = heap{size};
    size--;
    max_heap_fixdown(1, size);
  end

  function void max_heap_fixdown(num i,num size)
    log_marker("SYSTEM", "INFO", "In the beggining of the max_heap_fixdonw().");
    var num j = 2 * i;
    var num temp = heap{i};
    while (j <= size) do
      if (((j + 1) <= size) and (heap{j + 1} > heap{j})) then
        j++;
      end
      if (heap{j} < temp) then
        break;
      end
      heap{i} = heap{j};
      i = j;
      j = 2 * i;
    end
    heap{i} = temp;
    log_marker("FIXDOWN", "INFO", "In the end of the max_heap_fixdonw().");
  end

  function void heap_sort()
    for i from size to 2 step -1 do
      var num temp = heap{i};
      heap{i} = heap{1};
      heap{1} = temp;
      max_heap_fixdown(1, i - 1);
    end
  end

  function void clear_heap()
    size = 0;
  end

end

! CHECK: CONSOLE
! CHECK: SYSTEM
! CHECK: INFO
! CHECK: [SYSTEM] [INFO] In the isEmpty() function.
! CHECK: The heap is empty.
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: 46
! CHECK: 35
! CHECK: 20
! CHECK: 2
! CHECK: 22
! CHECK: [SYSTEM] [INFO] -------------
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: 22
! CHECK: 2
! CHECK: 20
! CHECK: [SYSTEM] [INFO] -------------
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: 120
! CHECK: 110
! CHECK: 70
! CHECK: 62
! CHECK: 80
! CHECK: 20
! CHECK: 26
! CHECK: 2
! CHECK: 42
! CHECK: 22
! CHECK: -------------
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: [SYSTEM] [INFO] In the beggining of the max_heap_fixdonw().
! CHECK: 2
! CHECK: 20
! CHECK: 22
! CHECK: 26
! CHECK: 42
! CHECK: 62
! CHECK: 70
! CHECK: 80
! CHECK: 110
! CHECK: 120
! CHECK: -------------
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] In the end of the max_heap_fixup().
! CHECK: [SYSTEM] [INFO] Before the ifFull() function.
! CHECK: [SYSTEM] [INFO] In the isFull() function.
! CHECK: The heap is full.
! CHECK: [SYSTEM] [INFO] In the isEmpty() function.
! CHECK: The heap is empty.
