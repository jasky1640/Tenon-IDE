module stack_record

  ! define the max num of stack
  const num stack_max_size = 100;
  ! define the empty tos
  const num empty_tos = 0;

  record position
    num no;
    string name;
    pos posdata;
  end

  var position stack{stack_max_size};
  var num top_of_stack = 0;

  function void main()
    ! judge the stack is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      tpwrite("The stack is empty.");
    else
      tpwrite("The stack is not empty.");
    end
    record_output();

    for i from 1 to 10 do
      push([i, "world", [0, 0, i]]);
    end
    record_output();

    for i from 1 to 11 do
      pop();
    end
    record_output();

    for i from 1 to 101 do
      push([i, "world", [0, 0, i]]);
    end
    record_output();

    ! judge the stack is full or not
    var bool bFull = isFull();
    if (bFull == true) then
      tpwrite("The stack is full.");
    else
      tpwrite("The stack is not full.");
    end
  end

  function bool isEmpty()
    if (top_of_stack == empty_tos) then
      return true;
    else
      return false;
    end
  end

  function bool isFull()
    if (top_of_stack == stack_max_size) then
      return true;
    else
      return false;
    end
  end

  function void record_output()
    if (top_of_stack == empty_tos) then
      tpwrite("The stack is empty, can't output data.");
      return;
    end

    tpwrite_num(stack{top_of_stack}.no);
    tpwrite_string(stack{top_of_stack}.name);
    tpwrite_pos(stack{top_of_stack}.posdata);
  end



  function void push(position pushpos)
    if (top_of_stack == 100) then
      tpwrite("The stack is full.");
      return;
    end
    top_of_stack = top_of_stack + 1;
    stack{top_of_stack} = pushpos;
  end

  function void pop()
    if (top_of_stack == empty_tos) then
      tpwrite("The stack is empty.");
      return;
    end
    top_of_stack = top_of_stack - 1;
  end

end
