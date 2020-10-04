int main() {
    //number of tuple can be 2~n
    // auto r1 = make_tuple(3.8, 'A', "Lisa Simpson");
    // auto r2 = make_tuple(2.9, 'C', "Milhouse Van Houten");
    tuple<double,char,string> r3 = {1.7, 'D', "Ralph Wiggum"};
    map<string,tuple<double,char,string>> tmap;
    // tmap["r1"] = r1;
    // tmap["r2"] = r2;
    // tmap["r3"] = r3;
    tmap["r1"] = {3.8, 'A', "Lisa Simpson"};
    tmap["r2"] = {2.9, 'C', "Milhouse Van Houten"};
    tmap["r3"] = r3;
    for(auto t:tmap){
        cout<<get<0>(t)<<" ";
        auto record = get<1>(t);
        cout<<get<0>(record)<<" "<<get<1>(record)<<" "<<get<2>(record)<<endl;
    }
        
}
