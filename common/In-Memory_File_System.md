# Python
```
class FileSystem:
    class file:
        def __init__(self,content = ""):
            #self.isFile = False
            self.content = content
            self.files = {}
    def __init__(self):
        self.root = self.file()

    def ls(self, path: str) -> List[str]:
        pwd = path.split('/')[1:]
        node = self.root
        for p in pwd:
            if p in node.files: 
                node = node.files[p]
            else:
                break
        if node.content !="": return [pwd[-1]]
        return sorted(list(node.files))
        

    def mkdir(self, path: str) -> None:
        pwd = path.split('/')[1:]
        node = self.root
        for p in pwd:
            if p in node.files: 
                node = node.files[p]
            else:
                node.files[p] = self.file()
                node = node.files[p]
        

    def addContentToFile(self, filePath: str, content: str) -> None:
        pwd = filePath.split('/')[1:]
        node = self.root
        for p in pwd:
            if p in node.files: 
                node = node.files[p]
            else:
                node.files[p] = self.file(content)
                node = node.files[p]
                return
        node.content += content

    def readContentFromFile(self, filePath: str) -> str:
        pwd = filePath.split('/')[1:]
        node = self.root
        for p in pwd:
            if p in node.files: 
                node = node.files[p]
        return node.content
                

# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)
```
# Java
```
class FileSystem {
    class Dir{
        boolean isDir = true;
        String name;
        StringBuilder content= new StringBuilder();
        HashMap<String,Dir> files = new HashMap<String,Dir>();
        public Dir(String name){
            this.name = name;
        }
        public void addContent(String content){
            this.content.append(content);
            isDir = false;
        }
    }
    Dir root = new Dir("root");
    public FileSystem() {
        
    }
    
    public List<String> ls(String path) {
        var curr = root;
        List<String> listPath =new ArrayList<String>();
        for(var p :path.split("/"))
            if (!p.equals("")){
                if(curr.isDir){
                    curr = curr.files.get(p);
                }
                else{
                    for(var file:curr.files.entrySet()){
                        listPath.add(file.getValue().name);
                    }
                    break;
                }
            }
        for(var file:curr.files.entrySet()){
            listPath.add(file.getValue().name);
        }
        
        Collections.sort(listPath);
        if (listPath.isEmpty() & !curr.isDir)
            listPath.add(curr.name);
        return listPath;
    }
    
    public void mkdir(String path) {
        var curr = root;
        for(var p :path.split("/"))
            if (!p.equals("")){
                if(!curr.isDir)
                    break;
                if(curr.files.containsKey(p))
                    curr = curr.files.get(p);
                else{
                    curr.files.put(p,new Dir(p));
                    curr = curr.files.get(p);
                }
                
            }
    }
    
    public void addContentToFile(String filePath, String content) {
        var curr = root;
        for(var p :filePath.split("/"))
            if (!p.equals("")){
                if(!curr.isDir){
                    curr.addContent(content);
                }
                if(curr.files.containsKey(p))
                    curr = curr.files.get(p);
                else{
                    curr.files.put(p,new Dir(p));
                    curr = curr.files.get(p);
                }
            }
        curr.addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        var curr = root;
        for(var p :filePath.split("/"))
            if (!p.equals("")){
                if(!curr.isDir){
                    return curr.content.toString();
                }
                if(curr.files.containsKey(p)){
                    
                    curr = curr.files.get(p);
                }
                else{
                    curr.files.put(p,new Dir(p));
                    curr = curr.files.get(p);
                }
                
            }
        return curr.content.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
```
