Add user
------------
localhost:8080/socialNetwork/users/login 
ModelAttribute userId 

For Adding Message
-------------------
localhost:8080/socialNetwork/user/page?message="demo message"&userId="currentUserID"

For retrieving message in reverse chronological order of the current user
--------------------------------------------------------------------------
localhost:8080/socialNetwork/user/wall/data?userId="currentUserID"

For fetching whole users of the social network
-------------------------------------------------
localhost:8080/socialNetwork/fetch/users/all

For following a particular user
------------------------------------
localhost:8080/socialNetwork/follow/user?followUserId="Id of the user to be followed"

For retrieving messages of followed user
-----------------------------------------
localhost:8080/socialNetwork/follow/user/wall