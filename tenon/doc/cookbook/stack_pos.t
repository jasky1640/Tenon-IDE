module stack_pos

  ! define the max num of stack
  const num stack_max_size = 100;
  ! define the empty tos
  const num empty_tos = 0;

  var pos stack{stack_max_size};
  var num top_of_stack = 0;

  function void main()
    ! judge the stack is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      tpwrite("The stack is empty.");
    else
      tpwrite("The stack is not empty.");
    end

    for i from 1 to 10 do
      push([0, 0, i]);
    end

    for i from 1 to 11 do
      pop();
    end

    for i from 1 to 101 do
      push([0, 0, i]);
    end

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

  function void push(pos pushpos)
    if (top_of_stack == 100) then
      tpwrite("The stack is full.");
      return;
    end
    top_of_stack = top_of_stack + 1;
    stack{top_of_stack} = pushpos;
    tpwrite_pos(stack{top_of_stack});
  end

  function void pop()
    if (top_of_stack == empty_tos) then
      tpwrite("The stack is empty.");
      return;
    end
    tpwrite_pos(stack{top_of_stack});
    top_of_stack = top_of_stack - 1;
  end

end
