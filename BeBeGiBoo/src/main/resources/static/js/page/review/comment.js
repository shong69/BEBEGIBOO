const selectCommentList=()=>{


    fetch("/comment?boardNo?"+boardNo)
    .then(resp => resp.json())
    .then(result => {
        console.log(commentList);

        const ul = document.querySelector("#commentList");

        ul.innerHTML="";

        for(let comment of commentList){
            const commentRow = document.createElement('li');

            commentRow.classList.add('commentRow');

            if(comment.parentCommentNo != 0)
                commentRow.classList.add("childComment");

            if(comment.commentDelF == 'Y')
                commentRow.innerText = "삭제된 댓글입니다";

            else{ //삭제되지 않은 댓글

                const commentWriter = document.createElement("p");
                commentWriter.classList.add("commentWriter");

                const memberId = document.createElement("span");
                memberId.innerText = comment.memberId;

                const commentDate = document.createElement("span");
                commentDate.classList.add("commentDate");
                commentDate.innerText = comment.commentWriteDate;

                commentWriter.append(memberId, commentDate);

                commentRow.append(commentWriter);

            }

        }
    })
}