module stack_string

  ! define the max num of stack
  const num stack_max_size = 100;
  ! define the empty tos
  const num empty_tos = 0;

  var string stack{stack_max_size};
  var num top_of_stack = 0;

  function void main()
    ! judge the stack is empty or not
    var bool bEmpty = isEmpty();
    if (bEmpty == true) then
      twrite("The stack is empty.");
    else
      twrite("The stack is not empty.");
    end

    for i from 1 to 10 do
      push("hello");
    end

    for i from 1 to 11 do
      pop();
    end

    for i from 1 to 101 do
      push("world");
    end

    ! judge the stack is full or not
    var bool bFull = isFull();
    if (bFull == true) then
      twrite("The stack is full.");
    else
      twrite("The stack is not full.");
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

  function void push(string pushstr)
    if (top_of_stack == 100) then
      twrite("The stack is full.");
      return;
    end
    top_of_stack = top_of_stack + 1;
    stack{top_of_stack} = pushstr;
    twrite_string(stack{top_of_stack});
  end

  function void pop()
    if (top_of_stack == empty_tos) then
      twrite("The stack is empty.");
      return;
    end
    twrite_string(stack{top_of_stack});
    top_of_stack = top_of_stack - 1;
  end

end
