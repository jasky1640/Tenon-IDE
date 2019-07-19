module key_indexed_counting

  record group
    string name;
    num groupID;
  end

  const num group_length = 20;
  const num groupID_count = 4;

  function void main()

    var group a{group_length} = [["Anderson", 2], ["Brown", 3], ["Davis", 3],
                       ["Garcia", 4], ["Harris", 1], ["Jackson", 3],
                       ["Johnson", 4], ["Jones", 3], ["Martin", 1],
                       ["Martinez", 2], ["Miller", 2], ["Moore",1],
                       ["Robinson", 2], ["Smith", 4], ["Taylor", 3],
                       ["Thomas", 4], ["Thompson", 4], ["White", 2],
                       ["Williams",3], ["Wilson", 4]];
    var group b{group_length};
    var num count{groupID_count};

    ! compute the frequency counts
    for i from 1 to group_length do
      count{a{i}.groupID}++;
    end
    for i from 1 to groupID_count do
      twrite_num(count{i});
    end
    twrite("-------------------");

    ! transform counts to indices
    for i from 1 to 3 do
      count{i + 1} = count{i + 1} + count{i};
    end
    for i from 1 to groupID_count do
      twrite_num(count{i});
    end
    twrite("-------------------");

    var num temp = 1;
    for i from 1 to group_length do
      if (a{i}.groupID > 1) then
        b{++count{a{i}.groupID - 1}} = a{i};
      else
        b{temp++} = a{i};
      end
    end
    for i from 1 to group_length do
      twrite_num(b{i}.groupID);
    end
    twrite("-------------------");

    for i from 1 to group_length do
      a{i} = b{i};
      twrite(a{i}.name);
      twrite_num(a{i}.groupID);
    end
  end

end
