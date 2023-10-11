function sortArr(args, sortingDirection) {
    if(sortingDirection === "asc"){
        return args.sort((a,b) => a-b);
    }
    return args.sort((a,b) => b-a);
}

console.log(sortArr([14,7,17,6,8], 'asc'))