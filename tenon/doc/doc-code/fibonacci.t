module fibonacci

  const num fib_count = 20;

  function void main()
    for i from 1 to fib_count do
      var num temp = fibonacci_recursion(i);
      twrite_num(temp);
    end
    twrite("--------------------");

    for i from 1 to fib_count do
      var num temp1 = fibonacci_no_recursion(i);
      twrite_num(temp1);
    end
  end

  function num fibonacci_recursion(num n)
    if (n <=2 ) then
      return 1;
    else
      return (fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2));
    end
  end

  function num fibonacci_no_recursion(num n)
    var num last;
    var num nextToLast;
    var num answer;

    if (n <= 2) then
      return 1;
    end

    last = 1;
    nextToLast = 1;
    for i from 3 to n do
      answer = last + nextToLast;
      nextToLast = last;
      last = answer;
    end

    return answer;
  end

end
