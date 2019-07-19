module queue_num

  ! define the max num of queue(contain front and rear)
  const num queue_max_size = 102;
  ! define the queue size
  var num size = 0;

  var num queue{queue_max_size};
  var num front = 1;
  var num rear = 2;

  function void main()
    ! judge the queue is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      twrite("The queue is empty.");
    else
      twrite("The queue is not empty.");
    end

    for i from 1 to 10 do
      en_queue(i);
    end
    output();

    for i from 1 to 5 do
      de_queue();
    end
    output();

    for i from 1 to 100 do
      en_queue(i);
    end
    output();

    ! judge the stack is full or not
    var bool bFull = isFull();
    if (bFull == true) then
      twrite("The queue is full.");
    else
      twrite("The queue is not full.");
    end

    clear_queue();
    output();

    bEmpty = false;
    bEmpty = isEmpty();
    if (bEmpty == true) then
      twrite("The queue is empty.");
    else
      twrite("The queue is not empty.");
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

  function void en_queue(num en_num)
    if (size == 100) then
      twrite("The queue is full.");
      return;
    end

    if ((size < 100) and (rear == 102)) then
      queue{rear} = en_num;
      rear = 1;
      size =  size + 1;
      return;
    end

    queue{rear} = en_num;
    rear = rear + 1;
    size = size + 1;
  end

  function void de_queue()
    if (size == 0) then
      twrite("The queue is empty.");
      return;
    end

    if ((size < 100) and (front == 102)) then
      front = 1;
      size =  size - 1;
      return;
    end

    front = front + 1;
    size = size - 1;
  end

  function void output()
    twrite_num(front);
    twrite_num(rear);
    if (size == 0) then
      twrite("The queue is empty.");
      return;
    end
    twrite_num(queue{front + 1});
    twrite_num(queue{rear - 1});
  end

  function void clear_queue()
    size = 0;
    front = 1;
    rear = 2;
  end

end
