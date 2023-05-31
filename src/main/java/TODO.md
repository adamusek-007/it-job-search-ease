
# How it works plan

1. Check Is Database Driver Installed;
	- If installed go further else exit(1);
2. SetupConnectionWithDatabase;
	- If Connection fails exit(2);
3. GetBoardsDataFromDatabase;
	- If result unreachable exit(3);
4. for(boards.count())
    1. Open the board job
    2. Do instructions that comes with board link
        1. clickOnElement(xPath)
        2. typeInBox(xPath, phraseToTypeIn);
        3. Statement = DatabaseOperator.createStatement;
        4. **Each site should be having its own set of xpath to elements such: to jobTitle** 
        5. scan(xPath);
            
	scan(xPath) {
	for(jobs.count){
                JobObj = scan(Map<Str jobDetail, Str jobxPath>);
                DatabaseOperator.checkDoesJobExist(JobObj);
                if (job !exist) {
                    add JobObj to Statement;
                }
                if(nextPage()){
                    click(xPath);
                }
            }
     }


## Commands types:
- click(path)
- typeIn(path, phrase)
- scan(xPath)