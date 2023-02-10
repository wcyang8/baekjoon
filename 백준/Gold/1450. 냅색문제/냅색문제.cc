#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class napsac {
private:
	int N, C;
	int* item;
	vector<int> left;
	vector<int> right;
public:
	napsac() {
		cin >> N >> C;
		item = new int[N];
		for (int i = 0; i < N; i++) {
			cin >> item[i];
		}
	}
	int solve(int curW, int start, int end, vector<int>* v) {
		if (curW > C) return 0;
		if (start >= end) {
			(*v).push_back(curW);
			return 1;
		}
		return solve(curW + item[start], start + 1, end, v) + solve(curW, start + 1, end, v);
	}
	int solvation() {
		int leftN, rightN, answer;

		leftN = solve(0, 0, N / 2, &left);
		rightN = solve(0, N / 2, N, &right);
		sort(right.begin(), right.end());

		answer = 0;
		for (auto i : left) {
			for (auto j : right) {
				if (i + j > C) {
					break;
				}
				answer++;
			}
		}
		return answer;
	}
};

int main() {
	napsac ns;

	cout << ns.solvation();

	return 0;
}