module string_insertion_sort

  const num arr_length = 10;
  var string a{arr_length};

  function void main()
    a = ["she", "sells", "seashells", "by", "the",
         "seashore", "sherf", "sell", "are", "surely"];

    for i from 1 to arr_length do
      tpwrite(a{i});
    end

    tpwrite("-----------------------");

    insertion_sort_func();
    for i from 1 to arr_length do
      tpwrite(a{i});
    end
  end

  function void insertion_sort_func()
    var string temp;
    var num j;
    for i from 2 to arr_length do
      temp = a{i};
      j = i;
      while ((j > 1) and (strorder(temp, a{j - 1}, STR_LOWER))) do
        a{j} = a{j - 1};
        j = j - 1;
      end
      a{j} = temp;
    end
  end

end
