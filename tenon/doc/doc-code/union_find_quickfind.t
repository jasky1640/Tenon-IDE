module union_find_quickfind

    const num N = 10;
    var num a{N}; 
    var num count = N; 

  function void main()

    for i from 1 to N do
      a{i} = i;
    end

    union(1, 9);
    union(1, 6);
    union(4, 9);
    union(5, 6);
    twrite_num(get_count());

    union(2, 3);
    twrite_num(get_count());

    union(7, 8);
    twrite_num(get_count());

    union(7, 4);
    twrite_num(get_count());

    var bool b_connect = connected(1, 10);
    if (b_connect == true) then
      twrite("The two elements are connected.");
    else
      twrite("The two elements are not connected.");
    end

    b_connect = connected(1, 5);
    if (b_connect == true) then
      twrite("The two elements are connected.");
    else
      twrite("The two elements are not connected.");
    end

  end

  function void union(num i, num j)
    var num iID = find(i);
    var num jID = find(j);
    if (iID == jID) then
      return;
    end
    for m from 1 to N do
      if(a{m} == iID) then
        a{m} = jID;
      end
    end
    count--;
  end

  function num find(num i)
    return a{i};
  end

  function bool connected(num i, num j)
    return find(i) == find(j);
  end

  function num get_count()
    return count;
  end
end
