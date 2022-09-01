function addComma(v) {
    return v.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}