module rehash

  record hash_item
    num key;
    string content;
  end

  ! create and init the hash table
  const num hash_table_len1 = 5;
  const num hash_table_len2 = 10;
  var hash_item hash_table{hash_table_len1, hash_table_len2};


  function void main()
  for i from 1 to hash_table_len1 do
    for j from 1 to hash_table_len2 do
      hash_table{i, j} = [-1, "null"];
    end
  end

    var hash_item item = [11, "eleven"];
    if (insert_item(item) == true) then
      tpwrite("Insert item success.");
    end;
    item = [12, "twelve"];
    if (insert_item(item) == true) then
      tpwrite("Insert item success.");
    end;
    for i from 1 to 10 do
      if (insert_item([i, "hash"]) == true) then
        tpwrite("Insert item success.");
      end;
    end

    item = [6, "hash"];
    if (find_item(item) == true) then
      tpwrite("Find item.");
    end;

    item = [8, "hash"];
    if (delete_item(item) == true) then
      tpwrite("Delete item success.");
    end;

  end

  function num hash_func1(num key)
    return (key mod 10) + 1;
  end

  function num hash_func2(num key)
    return (key mod 5) + 1;
  end

  function bool insert_item(hash_item item)
    var bool b_insert = false;
    var num index = hash_func2(hash_func1(item.key));
    for i from 1 to hash_table_len2 do
      if ((hash_table{index, i}.key == -1) and
         (hash_table{index, i}.content == "null")) then
        hash_table{index, i}.key = item.key;
        hash_table{index, i}.content = item.content;

        tpwrite_num(hash_table{index, i}.key);
        tpwrite_string(hash_table{index, i}.content);
        b_insert = true;
        break;
      end
    end
    return b_insert;
  end

  function bool find_item(hash_item item)
    var bool b_find = false;
    var num key_hash = hash_func2(hash_func1(item.key));
    for i from 1 to hash_table_len2 do
      if ((hash_table{key_hash, i}.key == item.key) and
          (hash_table{key_hash, i}.content == item.content)) then
        tpwrite_num(hash_table{key_hash, i}.key);
        tpwrite_string(hash_table{key_hash, i}.content);
        b_find = true;
      end
    end
    return b_find;
  end

  function bool delete_item(hash_item item)
    var bool b_del = false;
    var num key_hash = hash_func2(hash_func1(item.key));
    for i from 1 to 10 do
      if ((hash_table{key_hash, i}.key == item.key) and
          (hash_table{key_hash, i}.content == item.content)) then
        hash_table{key_hash, i}.key = -1;
        hash_table{key_hash, i}.content = "null";
        b_del = true;
      end
    end
    return b_del;
  end

end

