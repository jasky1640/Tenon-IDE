module graph_topsort

  const num graph_infor_len = 10;
  const num queue_length = 12;
  const num top_sort_length = 7;

  var num graph{graph_infor_len, graph_infor_len};
  var num queue{queue_length};
  var num queue_size = 0;
  var num queue_front = 1;
  var num queue_rear = 2;
  var num top_sort{top_sort_length};
  var num top_sort_index = 1;

  function void main()
    for i from 1 to graph_infor_len do
      for j from 1 to graph_infor_len do
        graph{i, j} = -1;
      end
    end

    ! init the graph
    graph{1, 1} = 2;
    graph{1, 2} = 3;
    graph{1, 3} = 4;
    graph{2, 1} = 4;
    graph{2, 2} = 5;
    graph{3, 1} = 6;
    graph{4, 1} = 3;
    graph{4, 2} = 6;
    graph{4, 3} = 7;
    graph{5, 1} = 4;
    graph{5, 2} = 7;
    graph{7, 1} = 6;

    for i from 1 to 7 do
      if (indegree_zero(i)) then
        en_queue(i);
      end
    end

    while (queue_size > 0) do
      var num temp = de_queue();
      top_sort{top_sort_index} = temp;
      top_sort_index++;

      var num vertex_index = 1;
      while (graph{temp, vertex_index} <> -1) do
        var num temp1 = graph{temp, vertex_index};
        graph{temp, vertex_index} = -1;
        if (indegree_zero(temp1)) then
          en_queue(temp1);
        end
        vertex_index++;
      end
    end

    for i from 1 to top_sort_length do
      tpwrite_num(top_sort{i});
    end
  end

  function bool indegree_zero(num n)
    var bool zero_inde = true;
    if (n > 7) then
      tpwrite("The graph doesn't has this point");
      return false;
    end

    for i from 1 to 7 do
      for j from 1 to 10 do
        if(graph{i, j} == n) then
          zero_inde = false;
        end
      end
    end

    return zero_inde;
  end


  function void en_queue(num en_num)
    if (queue_size == 10) then
      tpwrite("The queue is full.");
      return;
    end

    if ((queue_size < 10) and (queue_rear == 12)) then
      queue{queue_rear} = en_num;
      queue_rear = 1;
      queue_size =  queue_size + 1;
      return;
    end

    queue{queue_rear} = en_num;
    queue_rear = queue_rear + 1;
    queue_size = queue_size + 1;
  end

  function num de_queue()
    if (queue_size == 0) then
      tpwrite("The queue is empty.");
      return -1;
    end

    if ((queue_size < 10) and (queue_front == 12)) then
      queue_front = 1;
      queue_size =  queue_size - 1;
      return queue{queue_front};
    end

    queue_front = queue_front + 1;
    queue_size = queue_size - 1;
      return queue{queue_front};
  end
end

